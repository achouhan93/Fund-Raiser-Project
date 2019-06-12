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
              v-model="cause_title"
              :rules="[rules.required, rules.min]"
              required></v-text-field>
            <br>
            <v-select
              :items="category"
              label="Category"
              item-text="categoryName"
              item-value="categoryId"></v-select>
            <br>
            <v-text-field
              name="Description of the Cause"
              label="Description"
              id="description"
              multi-line
              v-model="description"
              :rules="[rules.required, rules.minLength]"
              required></v-text-field>
            <v-text-field
              name="in Euros"
              label="Targeted Amount"
              id="cause_target_amt"
              v-model="cause_target_amt"
              required></v-text-field>
            <br>
            <v-menu
              ref="menu"
              v-model="menu"
              :close-on-content-click="true"
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
              name="Please enter the Account Number"
              label="Account number"
              id="account_number"
              v-model="account_number"
              required></v-text-field>
            <br>
            <v-text-field
              name="Please enter the BIC Code"
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
import GetCauseService from '../services/CauseService'
import Stores from '@/store.js'
export default {
  data () {
    return {
      cause_title: '',
      category: Stores.state.categories,
      description: '',
      cause_target_amt: '',
      cause_expiration_date: null,
      account_number: '',
      code: '',
      status: ' ',
      rules: {
        required: value => !!value || 'Required.',
        min: v => v.length >= 8 || 'Minimum 8 characters',
        minLength: v => v.length >= 5 || 'Minimum 100 Words'
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

      const causedata = {
        'categoryId': 1,
        'causeTargetAmt': Number(this.cause_target_amt),
        'causeExpirationDate': this.cause_expiration_date,
        'description': this.description,
        'collectedAmt': 0,
        'causeTitle': this.cause_title,
        'isActive': true,
        'bankAccountNumber': this.account_number,
        'bic': this.code,
        'imageName': '3.png'
      }
      const res = await GetCauseService.createCause(causedata)
        .then(response => (this.status = response.data))
      console.log(res)
      this.navigateTo({ name: 'home' })
    }
  }
}
</script>
