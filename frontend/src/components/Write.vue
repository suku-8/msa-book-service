<template>
    <div>
        <Number
            label="WriteId"
            v-model="value.writeId"
            :editMode="editMode"
        />
        <Number
            label="UserId"
            v-model="value.userId"
            :editMode="editMode"
        />
        <String
            label="AuthorStatus"
            v-model="value.authorStatus"
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
    name: 'Write',
    mixins:[BaseEntity],
    components:{
    },
    
    data: () => ({
        path: "writes",
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
