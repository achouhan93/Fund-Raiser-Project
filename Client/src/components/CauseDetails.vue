<template>
  <v-layout>
    <v-flex xs12 sm6 offset-sm3>
      <v-card>
        <v-img
          v-bind:src="require('@/assets/'+ cause.data.imageName)"
          height="200px"
        ></v-img>

        <v-card-title primary-title>
          <div>
            <h3 class="headline causeTitle">{{ cause.data.causeTitle }}</h3>
            <div>{{ cause.data.description }} </div>
          </div>
        </v-card-title>

        <v-card-actions>
  <div>
          <div class="targetamount">Target Amount:</div>
         {{cause.data.causeTargetAmt}}
          <br>
          <div class="collectedamount"> Collected Amount: </div>
          {{cause.data.collectedAmt}}
  </div>
          <v-spacer></v-spacer>
          <v-btn class="cyan btn-update">Update</v-btn>
          <v-btn class="cyan btn-donate">Donate</v-btn>
        </v-card-actions>
      </v-card>
    </v-flex>
  </v-layout>
</template>

<script>
// import axios from 'axios'
import GetCauseService from '@/services/GetCauseService'
export default {
  name: 'CauseDetails',

  data () {
    return {
      // cause_title: this.$route.params.causeTitle
      cause: {},
      causeId: this.$route.params.causeId
    }
  },
  async mounted () {
    this.cause = await GetCauseService.getCauseById(this.causeId)
    console.log(this.cause)
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
