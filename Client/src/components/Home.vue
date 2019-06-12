<template>
  <v-layout justify-center>
    <v-flex xs12>
      <v-toolbar class="cyan">
        <v-toolbar-title class="home_title">Discover</v-toolbar-title>
        <v-spacer></v-spacer>
        <v-flex xs12 sm6 md3>
          <v-text-field
            class="mx-3 search_field"
            flat
            label="Search"
            solo
            v-model="cause_name"
          ></v-text-field> </v-flex>
        <v-flex xs12 sm6 md3>
          <v-select
            class="mx-3 search_field"
            :items="category"
            item-value="categoryValue"
            item-text="categoryName"
            label="Category"
            @change="searchCausefilter"
            name="search_category"
            solo></v-select>
        </v-flex>
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
              v-bind="{ [`xs${v_binding_flex}`]: true }">
              <v-card>
                <v-img
                  v-bind:src="require('@/assets/'+ cause.imageName)"
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
                  <v-btn>
                    <router-link v-bind:to="'/cause_details/' + cause.causeId">More</router-link>
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
import CauseDetails from '@/components/CauseDetails'
import GetCauseService from '@/services/CauseService'
import Stores from '@/store.js'

export default {
  name: 'Home',
  components: {
    Panel,
    CauseDetails
  },
  data () {
    return {
      causes: [],
      v_binding_flex: 6,
      causeId: '123',
      cause_name: ' ',
      category: Stores.state.categories
    }
  },
  async mounted () {
    this.causes = await GetCauseService.getAllCauses()
    GetCauseService.getAllCategories()
    console.log(Stores.state.categories)
  },
  methods: {
    async cause_detail (cause) {
      this.$router.push('cause_details', cause)
    },
    navigateTo (route) {
      this.$router.push(route)
    },
    async searchCausefilter (searchCategory) {
      console.log('name ', this.cause_name)
      console.log('search ', searchCategory)
      this.causes = await GetCauseService.getCauseByNameAndCategoryId(this.cause_name, searchCategory)
      console.log('res', this.causes)
    }
  }
}
console.log(this.causes)
</script>

<style>
  .home_title{
    color: white;
  }
  .search_field {
    margin: 10px auto auto;
    border: 1px;
  }
</style>
