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
            name="Title of the Cause"
            label="Title"
            id="cause_title"
            v-model="cause.causeTitle"
            :disabled="isDisabled"
            ></v-text-field>
          <br>
          <v-select
            :items="category"
            label="Category"></v-select>
          <br>
          <v-text-field
            name="Description of the Cause"
            label="Description"
            id="description"
            multi-line
            v-model="cause.description"
            :rules="[rules.required, rules.minLength]"
            required></v-text-field>
          <v-text-field
            name="in Euros"
            label="Targeted Amount"
            id="cause_target_amt"
            v-model="cause.causeTargetAmt"
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
                v-model="cause.causeExpirationDate"
                label="Expiration date"
                prepend-icon="event"
                readonly
                v-on="on"
              ></v-text-field>
            </template>
            <v-date-picker
              ref="picker"
              v-model="cause.causeExpirationDate"
              :min="new Date().toISOString().substr(0, 10)"
              max="2025-01-01"
            ></v-date-picker>
          </v-menu>
          <br>
          <v-text-field
          name="Please enter the Account Number"
          label="Account number"
          id="account_number"
          :disabled="isDisabled"
          v-model="account_number"
          required></v-text-field>
          <br>
          <v-text-field
            name="Please enter the BIC Code"
            label="BIC Code"
            id="code"
            :disabled="isDisabled"
            v-model="code"
            required></v-text-field>
          <br>
          <v-btn @click="updateCause" class="cyan btn-updateCause">Update Cause</v-btn>
        </div>
        </form>
      </div>
    </v-flex>
  </v-layout>
</template>

<script>
import axios from 'axios'
import GetCauseService from '@/services/GetCauseService'
export default {
  name: 'UpdateCause',
  data () {
    return {
      cause: this.$store.state.causeData,
      causeId: this.$store.state.causeId,
      isDisabled: true,
      rules: {
        required: value => !!value || 'Required.',
        min: v => v.length >= 8 || 'Minimum 8 characters',
        minLength: v => v.length >= 100 || 'Minimum 100 Words'
      },
      category: ['Natural Disaster', 'Personal', 'Education'],
      description: '',
      cause_target_amt: '',
      cause_expiration_date: null
    }
  },
  async mounted () {
    this.cause = await GetCauseService.getCauseById(this.causeId)
    console.log(this.cause)
  },

  computed: {
    formIsValid () {
      return this.category !== '' &&
          this.description !== '' &&
          this.cause_target_amt !== '' &&
          this.cause_expiration_date !== '' &&
          this.imageUrl !== ''
    },
    methods: {
      navigateTo (route) {
        this.$router.push(route)
      },
      async updateCause () {
        if (!this.formIsValid) {
          return
        }
        if (!this.image) {
          return
        }
        this.cause.description = this.description
        this.cause.category = this.category
        this.cause.causeExpirationDate = this.cause_expiration_date
        this.cause.causeTargetAmt = this.cause_target_amt
        await axios.put(`http://localhost:8085/cause/` + this.causeId,
          this.cause
        )
          .then(response => (this.status = response.data))

        this.navigateTo({name: 'home'})
      }
    }
  }
}
</script>
