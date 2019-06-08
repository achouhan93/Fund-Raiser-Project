<template>
    <v-toolbar fixed class="cyan">
        <v-toolbar-title class="mr-4">
          <span @click="navigateTo({name: 'home' })" class="home"> Fund Raiser
          </span>
          </v-toolbar-title>
        <v-toolbar-items>
            <v-btn flat dark @click="navigateTo({name: 'createcause' })"> Create Cause </v-btn>
        </v-toolbar-items>
        <v-spacer></v-spacer>
        <v-toolbar-items>
            <v-btn flat dark @click="navigateTo({name: 'testLogin' })">
                Login
            </v-btn>
        </v-toolbar-items>
    </v-toolbar>
</template>

<script>
export default {
  methods: {
    navigateTo (route) {
      this.$router.push(route)
    }
  }
}
</script>

<style>
.home{
  cursor: pointer;
}
</style>
