<template>
    <div>
        <Number
            label="BookId"
            v-model="value.bookId"
            :editMode="editMode"
        />
        <String
            label="UserId"
            v-model="value.userId"
            :editMode="editMode"
        />
        <String
            label="BookTitle"
            v-model="value.bookTitle"
            :editMode="editMode"
        />
        <String
            label="Author"
            v-model="value.author"
            :editMode="editMode"
        />
        <String
            label="Summary"
            v-model="value.summary"
            :editMode="editMode"
        />
        <String
            label="ImageUrl"
            v-model="value.imageUrl"
            :editMode="editMode"
        />
        <Date
            label="PublishDate"
            v-model="value.publishDate"
            :editMode="editMode"
        />
        <Number
            label="ViewCount"
            v-model="value.viewCount"
            :editMode="editMode"
        />
        <String
            label="Rank"
            v-model="value.rank"
            :editMode="editMode"
        />
        <Boolean
            label="Bestseller"
            v-model="value.bestseller"
            :editMode="editMode"
        />
        <String
            label="Category"
            v-model="value.category"
            :editMode="editMode"
        />
        <String
            label="Tags"
            v-model="value.tags"
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
    name: 'Library',
    mixins:[BaseEntity],
    components:{
    },
    
    data: () => ({
        path: "libraries",
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
