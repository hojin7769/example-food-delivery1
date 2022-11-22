<template>

    <v-data-table
        :headers="headers"
        :items="myDeliveryInfo"
        :items-per-page="5"
        class="elevation-1"
    ></v-data-table>

</template>

<script>
    const axios = require('axios').default;

    export default {
        name: 'MyDeliveryInfoView',
        props: {
            value: Object,
            editMode: Boolean,
            isNew: Boolean
        },
        data: () => ({
            headers: [
                { text: "id", value: "id" },
                { text: "foodId", value: "foodId" },
                { text: "status", value: "status" },
            ],
            myDeliveryInfo : [],
        }),
          async created() {
            var temp = await axios.get(axios.fixUrl('/myDeliveryInfos'))

            temp.data._embedded.myDeliveryInfos.map(obj => obj.id=obj._links.self.href.split("/")[obj._links.self.href.split("/").length - 1])

            this.myDeliveryInfo = temp.data._embedded.myDeliveryInfos;
        },
        methods: {
        }
    }
</script>

