<template>
    <v-toolbar fixed class="cyan">
        <v-toolbar-title class="mr-4"> Fund Raiser </v-toolbar-title>
        <v-toolbar-items>
            <v-btn flat dark> Browse Causes </v-btn>
        </v-toolbar-items>
        <v-spacer></v-spacer>
        <v-toolbar-items>
            <v-btn flat dark @click="navigateToRigester({name: 'register' })">
                SignUp
            </v-btn>
            <v-btn flat dark>
                Login
            </v-btn>
        </v-toolbar-items>
    </v-toolbar>
</template>

<script>
export default {
  methods: {
    navigateToRigester (route) {
      this.$router.push(route)
    }
  }
}
</script>

<style>

</style>
