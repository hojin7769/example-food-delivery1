<template>

    <v-card outlined>
        <v-card-title>
            PointInfo # {{$route.params.id }}
        </v-card-title>

        <v-card-text>
            <div>
                <Number label="Point" v-model="item.point" :editMode="editMode" @change="change" />
            </div>
        </v-card-text>
    </v-card>

</template>

<script>
  const axios = require('axios').default;

  export default {
    name: 'PointInfoViewDetail',
    props: {
      value: Object,
    },
    data: () => ({
        item : [],
    }),
    async created() {
      var params = this.$route.params;
      var temp = await axios.get(axios.fixUrl('/pointInfos/' + params.id))

      this.item = temp.data;

    },
    methods: {
    }
  }
</script>

