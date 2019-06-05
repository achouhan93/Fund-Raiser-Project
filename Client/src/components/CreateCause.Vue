<template xmlns:v-slot="http://www.w3.org/1999/XSL/Transform">
  <v-layout aria-rowcount="center">
    <v-flex xs6 offset-xs3>
      <div class="white elevation-2">
        <v-toolbar flat dense class="cyan" dark>
          <v-toolbar-title>Create a Cause</v-toolbar-title>
        </v-toolbar>
        <form>
        <div class="pl-4 pr-4 pb-2 pt-2">
          <br>
          <v-text-field
            name="title"
            label="Title"
            id="cause_title"
            v-model="cause_title"
            :rules="[rules.required, rules.min]"
            required></v-text-field>
          <br>
          <v-select
            :items="category"
            label="Category"></v-select>
          <br>
          <v-text-field
            name="description"
            label="Description"
            id="description"
            multi-line
            v-model="description"
            :rules="[rules.required, rules.min]"
            required></v-text-field>
          <br>
          <v-btn raised class="primary" @click="onPickFile">Upload Image</v-btn>
          <input
            type="file"
            style="display: none"
            ref="fileInput"
            accept="image/*"
            @change="onFilePicked">
          <img v-bind:src="imagePreview" v-show="showPreview"/>
          <br>
          <v-text-field
            name="in euros"
            label="Targeted Amount"
            id="cause_target_amt"
            v-model="cause_target_amt"
            required></v-text-field>
          <br>
          <v-menu
            ref="menu"
            v-model="menu"
            :close-on-content-click="false"
            :nudge-right="40"
            lazy
            transition="scale-transition"
            offset-y
            full-width
            min-width="290px"
          >
            <template v-slot:activator="{ on }">
              <v-text-field
                v-model="cause_expiration_date"
                label="Expiration date"
                prepend-icon="event"
                readonly
                v-on="on"
              ></v-text-field>
            </template>
            <v-date-picker
              ref="picker"
              v-model="cause_expiration_date"
              :min="new Date().toISOString().substr(0, 10)"
              max="2025-01-01"
            ></v-date-picker>
          </v-menu>
          <br>
          <v-text-field
          name="in euros"
          label="Account number"
          id="account_number"
          v-model="account_number"
          required></v-text-field>
          <br>
          <v-text-field
            name="in euros"
            label="BIC Code"
            id="code"
            v-model="code"
            required></v-text-field>
          <br>
          <v-btn @click="createCause" class="cyan btn-createCause">Create Cause</v-btn>
        </div>
        </form>
      </div>
    </v-flex>
  </v-layout>
</template>

<script>
import axios from 'axios'
export default {
  data () {
    return {
      cause_title: '',
      category: ['Natural Disaster', 'Personal', 'Education'],
      description: '',
      cause_target_amt: '',
      cause_expiration_date: null,
      account_number: '',
      code: '',
      image: null,
      status: ' ',
      rules: {
        required: value => !!value || 'Required.',
        min: v => v.length >= 8 || 'Min 8 characters',
        emailMatch: () => ('The email and password you entered dont match')
      }
    }
  },
  computed: {
    formIsValid () {
      return this.cause_title !== '' &&
        this.category !== '' &&
        this.description !== '' &&
        this.cause_target_amt !== '' &&
        this.cause_expiration_date !== '' &&
        this.account_number !== '' &&
        this.imageUrl !== '' &&
        this.code !== ''
    }
  },
  methods: {
    navigateTo (route) {
      this.$router.push(route)
    },
    async createCause () {
      if (!this.formIsValid) {
        return
      }
      if (!this.image) {
        return
      }
      var causedata = {
        'categoryId': 1,
        'causeTargetAmt': Number(this.cause_target_amt),
        'creationDate': this.cause_expiration_date,
        'causeExpirationDate': this.cause_expiration_date,
        'description': this.description,
        'collectedAmt': 0,
        'causeTitle': this.cause_title,
        'createdBy': 8,
        'bankAccountNumber': this.account_number,
        'bic': this.code,
        'imageName': '1.png',
        'active': true,
        image: this.image
      }

      await axios.post(`http://localhost:8085/cause/postCause?userId=8`,
        causedata
      )
        .then(response => (this.status = response.data))

      this.navigateTo({ name: 'home' })
    },
    onPickFile () {
      this.$refs.fileInput.click()
    },
    onFilePicked (event) {
      const files = event.target.files
      let filename = files[0].name
      if (filename.lastIndexOf('.') <= 0) {
        return alert('Please add a valid file!')
      }
      const fileReader = new FileReader()
      fileReader.addEventListener('load', () => {
        this.imageUrl = fileReader.result
      })
      fileReader.readAsDataURL(files[0])
      this.image = files[0]
    }

  }
}
</script>
