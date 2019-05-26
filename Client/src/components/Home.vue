<template>
  <v-layout>
    <v-flex>
      <panel title="causes">
        <div
          v-for="cause in causes"
          :key="cause.categoryId">
          {{cause.categoryId}}
          {{cause.causeTargetAmount}}
          {{cause.causeExpirationDate}}
          {{cause.description}}
          {{cause.collection}}
          {{cause.causeTitle}}
          {{cause.active}}
        </div>
      </panel>
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
          active: true
        },
        {
          categoryId: 1,
          causeTargetAmount: 6000,
          causeExpirationDate: '2019/10/30',
          description: 'Recently there was a flood in Kerala, This cause has been raised inorder to help the victims of the flood in kerala',
          collection: 100,
          causeTitle: 'Collection of fund for ferry cyclone in kerala',
          active: true
        },
        {
          categoryId: 1,
          causeTargetAmount: 6000,
          causeExpirationDate: '2019/10/30',
          description: 'Recently there was a flood in Kerala, This cause has been raised inorder to help the victims of the flood in kerala',
          collection: 100,
          causeTitle: 'Collection of fund for ferry cyclone in kerala',
          active: true
        },
        {
          categoryId: 1,
          causeTargetAmount: 6000,
          causeExpirationDate: '2019/10/30',
          description: 'Recently there was a flood in Kerala, This cause has been raised inorder to help the victims of the flood in kerala',
          collection: 100,
          causeTitle: 'Collection of fund for ferry cyclone in kerala',
          active: true
        },
        {
          categoryId: 1,
          causeTargetAmount: 6000,
          causeExpirationDate: '2019/10/30',
          description: 'Recently there was a flood in Kerala, This cause has been raised inorder to help the victims of the flood in kerala',
          collection: 100,
          causeTitle: 'Collection of fund for ferry cyclone in kerala',
          active: true
        }

      ]
    }
  },
  async mounted () {
    this.causes = await CauseService.getAllCauses()
  }
}
</script>
