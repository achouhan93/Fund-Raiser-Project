<template>
    <div>
      <h1>{{causeId}}</h1>
    </div>
</template>

<script>
export default {
  name: 'CauseDetails',
  data () {
    return {
      // cause_title: this.$route.params.causeTitle
      cause: ''
    }
  },
  props: ['causeId']
  /* async mounted () {
    const causeId = this.state.route.params.causeId
    console.log(causeId)
  } */

}
</script>

<style scoped>

</style>
