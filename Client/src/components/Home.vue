<template>
  <v-layout justify-center>
    <v-flex xs12>
      <v-toolbar class="cyan">
        <v-toolbar-title class="home_title">Discover</v-toolbar-title>
        <v-spacer></v-spacer>
        <v-btn icon>
          <v-icon>search</v-icon>
        </v-btn>
      </v-toolbar>
      <v-card>
        <v-container
          fluid
          grid-list-md
        >
          <v-layout row wrap>
            <v-flex
              v-for="cause in causes"
              :key="cause.causeTitle"
              v-bind="{ [`xs${cause.flex}`]: true }"
            >
              <v-card>
                <v-img
                  v-bind:src="require('@/assets/'+cause.imageUrl)"
                  height="200px"
                >
                  <v-container
                    fill-height
                    fluid
                    pa-2
                  >
                    <v-layout fill-height>
                      <v-flex xs12 align-end flexbox>
                        <span class="headline white--text" v-text="cause.causeTitle"></span>
                      </v-flex>
                    </v-layout>
                  </v-container>
                </v-img>

                <v-card-actions>
                  <v-spacer></v-spacer>
                  <v-btn class="cyan" icon>
                    <v-icon>favorite</v-icon>
                  </v-btn>
                  <v-btn class="cyan" icon>
                    <v-icon>bookmark</v-icon>
                  </v-btn>
                  <v-btn class="cyan" icon>
                    <v-icon>share</v-icon>
                  </v-btn>
                </v-card-actions>
              </v-card>
            </v-flex>
          </v-layout>
        </v-container>
      </v-card>
    </v-flex>
  </v-layout>
</template>

<script>
import Panel from '@/components/Panel'
import CauseService from '@/services/GetCauseService'
export default {
  components: {
    Panel
  },
  data () {
    return {
      causes: null
    }
  },
  async mounted () {
    this.causes = CauseService.getAllCauses()
  }
}
</script>

<style>
  .home_title{
    color: white;
  }
</style>
