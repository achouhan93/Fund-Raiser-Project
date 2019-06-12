<template>
  <v-layout row wrap>
    <v-flex xs12 sm6 offset-sm3>
      <v-card>
        <v-img
          v-bind:src="require('@/assets/'+ cause.imageName)"
          height="200px"
        ></v-img>

        <v-card-title primary-title>
          <div>
            <h3 class="headline causeTitle">{{ cause.causeTitle }}</h3>
            <div>{{ cause.description }} </div>
          </div>
        </v-card-title>

        <v-card-actions>
  <div>
          <div class="targetamount">Target Amount:</div>
         {{cause.causeTargetAmt}}
          <br>
          <div class="collectedamount"> Collected Amount: </div>
          {{cause.collectedAmt}}
  </div>
          <v-spacer></v-spacer>
            <v-btn class="cyan btn-update" :disabled= !isUserSignedIn @click="navigateTo({name: 'updateCause' })">Update</v-btn>
            <v-btn class="cyan btn-donate" :disabled= !isUserSignedIn @click="initDonation">Donate</v-btn>
        </v-card-actions>
        <span v-if="!isUserSignedIn">Please login to donate for the cause </span>
      </v-card>
    </v-flex >
    <br>
    <v-flex xs12 sm6 offset-sm3 v-if="donationPanelVisible">
      <v-card>
        <v-card-title primary-title>
          <div class="headline causeTitle">
            Please enter the amount you want to donate for this cause
          </div>
        </v-card-title>
          <v-flex xs8 align-center>
            <div class="pl-4 pr-4 pt-2">
          <v-text-field class="headline"
            name="donationAmount"
            label="Donation Amount"
            placeholder="Donation Amount"
            v-validate="'numeric|min_value:1|max_value:'+maxDonationValue"
            v-model="donationAmount" solo></v-text-field>
          <span v-show="errors.has('donationAmount')" class="error--text" >{{ errors.first('donationAmount') }}</span>
          <br>
            </div>
            <div>
              <v-btn class="cyan btn-update" @click="cancelDonation">Cancel</v-btn>
              <v-btn class="cyan btn-donate" >Pay</v-btn>
            </div>
          </v-flex>
      </v-card>
    </v-flex>

  </v-layout>
</template>

<script>
// import axios from 'axios'
import GetCauseService from '@/services/CauseService'
export default {
  name: 'CauseDetails',

  data () {
    return {
      // cause_title: this.$route.params.causeTitle
      cause: {},
      causeId: this.$route.params.causeId,
      isUserSignedIn: this.$store.state.signedIn,
      donationAmount: '',
      donationPanelVisible: false,
      maxDonationValue: 0
    }
  },
  async mounted () {
    this.cause = await GetCauseService.getCauseById(this.causeId)
    this.$store.state.causeData = this.cause
  },
  methods: {
    cancelDonation () {
      this.donationPanelVisible = false
    },
    initDonation () {
      this.donationPanelVisible = true
      this.maxDonationValue = this.cause.causeTargetAmt - this.cause.collectedAmt
    },
    navigateTo (route) {
      this.$store.state.causeId = this.causeId
      this.$router.push(route)
    }
  }
}
</script>

<style scoped>
.targetamount {
  color: black;
  font-weight: bold;
}
  .collectedamount {
    color: black;
    font-weight: bold;
  }
  .btn-donate {
    color: white;
  }
  .btn-update {
    color: white;
  }
  .causeTitle {
    font-weight: bolder;
  }
</style>
