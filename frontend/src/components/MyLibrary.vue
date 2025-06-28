<template>
    <div>
        <Number
            label="UserId"
            v-model="value.userId"
            :editMode="editMode"
        />
        <String
            label="Point"
            v-model="value.point"
            :editMode="editMode"
        />
        <String
            label="IsSubscribe"
            v-model="value.isSubscribe"
            :editMode="editMode"
        />
        <String
            label="BookId"
            v-model="value.bookId"
            :editMode="editMode"
        />
        <String
            label="IsBuy"
            v-model="value.isBuy"
            :editMode="editMode"
        />
        <v-row class="ma-0 pa-0">
            <v-spacer></v-spacer>
            <v-btn width="64px" color="primary" @click="save">
                저장
            </v-btn>
        </v-row>
    </div>
</template>


<script>
import BaseEntity from './base-ui/BaseEntity.vue'

export default {
    name: 'MyLibrary',
    mixins:[BaseEntity],
    components:{
    },
    
    data: () => ({
        path: "myLibraries",
        value: {
        }
    }),
    created(){
    },
    computed:{
    },
    methods: {
    },
}
</script>
