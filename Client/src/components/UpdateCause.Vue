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
              disabled
              v-validate="'required|min:10'"
            ></v-text-field>
            <span v-show="errors.has('Title of the Cause')" class="error--text" >{{ errors.first('Title of the Cause') }}</span>
            <br>
            <v-text-field
              name="Description of the Cause"
              label="Description"
              id="description"
              multi-line
              v-model="cause.description"
              v-validate="'required|min:50'"
              required></v-text-field>
            <span v-show="errors.has('Description of the Cause')" class="error--text" >{{ errors.first('Description of the Cause') }}</span>
            <v-text-field
              name="Target Amount"
              label="Targeted Amount"
              id="cause_target_amt"
              v-model="cause.causeTargetAmt"
              v-validate="'required|numeric|min_value:'+cause_collected_amt"
            ></v-text-field>
            <span v-show="errors.has('Target Amount')" class="error--text" >{{ errors.first('Target Amount') }}</span>
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
            <v-btn @click="updCause" class="cyan btn-updateCause">Update Cause</v-btn>
          </div>
        </form>
      </div>
    </v-flex>
  </v-layout>
</template>

<script>
import CauseService from '../services/CauseService'
export default {
  name: 'UpdateCause',
  data () {
    return {
      cause: this.$store.state.causeData,
      causeId: this.$store.state.causeId,
      isDisabled: true,
      description: '',
      cause_collected_amt: this.$store.state.causeData.collectedAmt,
      cause_expiration_date: this.$store.state.causeData.causeExpirationDate
    }
  },
  computed: {
    formIsValid () {
      return this.category !== '' &&
          this.description !== '' &&
          this.cause_target_amt !== ''
    }
  },
  methods: {
    navigateTo (route) {
      this.$router.push(route)
    },
    async updCause () {
      this.$validator.validateAll()
      if (!this.errors.any()) {
        console.log(this.cause)
        this.cause.causeExpirationDate = this.cause_expiration_date
        await CauseService.updateCause(this.cause)
          .then(response => (this.status = response.data))
        this.navigateTo({name: 'home'})
      }
    }
  }
}
</script>
