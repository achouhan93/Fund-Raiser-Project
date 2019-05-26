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
      causes: [
        {
          categoryId: 1,
          causeTargetAmount: 6000,
          causeExpirationDate: '2019/10/30',
          description: 'Recently there was a flood in Kerala, This cause has been raised inorder to help the victims of the flood in kerala',
          collection: 100,
          causeTitle: 'Collection of fund for ferry cyclone in kerala',
          active: true,
          imageUrl: '1.png',
          flex: 6
        },
        {
          categoryId: 2,
          causeTargetAmount: 6000,
          causeExpirationDate: '2019/10/30',
          description: 'Recently there was a flood in Kerala, This cause has been raised inorder to help the victims of the flood in kerala',
          collection: 100,
          causeTitle: 'Collection of fund for ferry cyclone in kerala',
          active: true,
          imageUrl: '2.png',
          flex: 6
        },
        {
          categoryId: 3,
          causeTargetAmount: 6000,
          causeExpirationDate: '2019/10/30',
          description: 'Recently there was a flood in Kerala, This cause has been raised inorder to help the victims of the flood in kerala',
          collection: 100,
          causeTitle: 'Collection of fund for ferry cyclone in kerala',
          active: true,
          imageUrl: '3.png',
          flex: 6
        },
        {
          categoryId: 4,
          causeTargetAmount: 6000,
          causeExpirationDate: '2019/10/30',
          description: 'Recently there was a flood in Kerala, This cause has been raised inorder to help the victims of the flood in kerala',
          collection: 100,
          causeTitle: 'Collection of fund for ferry cyclone in kerala',
          active: true,
          imageUrl: '4.png',
          flex: 6
        },
        {
          categoryId: 5,
          causeTargetAmount: 6000,
          causeExpirationDate: '2019/10/30',
          description: 'Recently there was a flood in Kerala, This cause has been raised inorder to help the victims of the flood in kerala',
          collection: 100,
          causeTitle: 'Collection of fund for ferry cyclone in kerala',
          active: true,
          imageUrl: '5.png',
          flex: 6
        },
        {
          categoryId: 2,
          causeTargetAmount: 6000,
          causeExpirationDate: '2019/10/30',
          description: 'Recently there was a flood in Kerala, This cause has been raised inorder to help the victims of the flood in kerala',
          collection: 100,
          causeTitle: 'Collection of fund for ferry cyclone in kerala',
          active: true,
          imageUrl: '2.png',
          flex: 6
        },
        {
          categoryId: 3,
          causeTargetAmount: 6000,
          causeExpirationDate: '2019/10/30',
          description: 'Recently there was a flood in Kerala, This cause has been raised inorder to help the victims of the flood in kerala',
          collection: 100,
          causeTitle: 'Collection of fund for ferry cyclone in kerala',
          active: true,
          imageUrl: '3.png',
          flex: 6
        }

      ]
    }
  },
  async mounted () {
    this.causes = await CauseService.getAllCauses()
  }
}
</script>

<style>

  .cause_title{
    font-size: 30px;
    font-weight: bold;
  }
  .cause_collection{
    font-size: 18px;
    font-weight: bold;
  }
  .cause_description {
    font-size: 18px;
  }
  .cause_target_amount {
    font-size: 18px;
  }
  .cause_expiration_date {
    font-weight: bold;
    font-weight: 18px;
  }
  .album-image{
    width: 70%;
    margin: 0 auto;
  }
  .homePanel{
    background: bisque;
  }
  .home_title{
    color: white;
  }
</style>
