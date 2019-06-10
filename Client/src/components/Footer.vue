<template xmlns:v-slot="http://www.w3.org/1999/XSL/Transform">
  <v-footer fixed class="cyan" dark
            height="auto">
    <v-card
      class="flex"
      flat
      tile
    >
      <v-card-title class="cyan">
        <strong class="subheading">About us </strong>
        <br>
        <br>
        <strong class="subheading">Fund Raisers empowers you to raise money for anything that matters to you. From personal causes and events to projects and more. Bring your community to life with dynamic profiles that update with every interaction and automatically sync with public social media. </strong>
        <br>
        <br>
        <strong class="subheading">Contact us  Phone: +49 6221 88-1000   Email: info@stud.hochschule-heidelberg.de</strong>
        <v-spacer></v-spacer>
        <v-btn
          v-for="icon in icons"
          :key="icon"
          class="mx-3"
          dark
          icon
        >
          <v-icon size="24px">{{ icon }}</v-icon>
        </v-btn>
      </v-card-title>

      <v-card-actions class="grey darken-3 justify-center">
        &copy;2019 — <strong>Fund Raiser</strong>
      </v-card-actions>
    </v-card>
  </v-footer>
</template>

<script>
export default {
  data: () => ({
    icons: [
      'fab fa-facebook',
      'fab fa-twitter',
      'fab fa-google-plus',
      'fab fa-linkedin',
      'fab fa-instagram'
    ]
  })
}
</script>
