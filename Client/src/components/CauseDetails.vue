<template>
    <div>
      <h1>This is CauseDetails Page </h1>
      <h1>{{causeId}}</h1>
    </div>
</template>

<script>
export default {
  name: 'CauseDetails',
  data () {
    return {
      // cause_title: this.$route.params.causeTitle
      cause: '',
      causeId: this.$route.params.causeId
    }
  }

}
</script>

<style scoped>

</style>
