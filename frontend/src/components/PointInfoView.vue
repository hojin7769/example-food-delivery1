<template>

    <v-data-table
        :headers="headers"
        :items="pointInfo"
        :items-per-page="5"
        class="elevation-1"
    ></v-data-table>

</template>

<script>
    const axios = require('axios').default;

    export default {
        name: 'PointInfoView',
        props: {
            value: Object,
            editMode: Boolean,
            isNew: Boolean
        },
        data: () => ({
            headers: [
                { text: "id", value: "id" },
                { text: "point", value: "point" },
            ],
            pointInfo : [],
        }),
          async created() {
            var temp = await axios.get(axios.fixUrl('/pointInfos'))

            temp.data._embedded.pointInfos.map(obj => obj.id=obj._links.self.href.split("/")[obj._links.self.href.split("/").length - 1])

            this.pointInfo = temp.data._embedded.pointInfos;
        },
        methods: {
        }
    }
</script>

