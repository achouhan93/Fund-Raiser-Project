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
            required></v-text-field>
          <br>
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
              :max="new Date().toISOString().substr(0, 10)"
              min="1950-01-01"
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
      status: ' '
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
        this.code !== ''
    }
  },
  methods: {
    createCause () {
      if (!this.formIsValid) {
        return
      }
      const causedata = {
        cause_title: this.cause_title,
        category: this.category,
        description: this.description,
        cause_target_amt: this.cause_target_amt,
        cause_expiration_date: this.cause_expiration_date,
        account_number: this.account_number,
        code: this.code
      }

      axios.post(`http://localhost:8085/cause/postCause`, {
        body: this.causedata
      })
        .then(response => (this.status = response.data))

      this.$store.dispatch('createcause', causedata)
      this.$router.push('/home')
    }
  }
}
</script>
