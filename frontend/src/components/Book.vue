<template>
    <div>
        <Number
            label="BookId"
            v-model="value.bookId"
            :editMode="editMode"
        />
        <String
            label="OriginWriteId"
            v-model="value.originWriteId"
            :editMode="editMode"
        />
        <String
            label="UserId"
            v-model="value.userId"
            :editMode="editMode"
        />
        <String
            label="Title"
            v-model="value.title"
            :editMode="editMode"
        />
        <String
            label="Content"
            v-model="value.content"
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
    name: 'Book',
    mixins:[BaseEntity],
    components:{
    },
    
    data: () => ({
        path: "books",
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
