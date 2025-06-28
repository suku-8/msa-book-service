<script setup>
import {
  VerticalNavLink,
  VerticalNavSectionTitle,
} from '@layouts'
</script>

<template>
    <ul>
        <VerticalNavSectionTitle :item="{ heading: 'signup' }" />
        <VerticalNavLink
            :item="{
                title: 'User',
                to: '/users',
            }"
        />
        <VerticalNavSectionTitle :item="{ heading: 'writemanage' }" />
        <VerticalNavLink
            :item="{
                title: 'Write',
                to: '/writes',
            }"
        />
        <VerticalNavLink
            :item="{
                title: 'Book',
                to: '/books',
            }"
        />
        <VerticalNavLink
            :item="{
                title: 'AuthorInfo',
                to: '/authorInfos',
            }"
        />
        <VerticalNavSectionTitle :item="{ heading: 'ai' }" />
        <VerticalNavLink
            :item="{
                title: 'CoverDesign',
                to: '/coverDesigns',
            }"
        />
        <VerticalNavLink
            :item="{
                title: 'ContentAnalyzer',
                to: '/contentAnalyzers',
            }"
        />
        <VerticalNavSectionTitle :item="{ heading: 'point' }" />
        <VerticalNavLink
            :item="{
                title: 'Point',
                to: '/points',
            }"
        />
        <VerticalNavSectionTitle :item="{ heading: 'Libraryplatform' }" />
        <VerticalNavLink
            :item="{
                title: 'Library',
                to: '/libraries',
            }"
        />
        <VerticalNavLink
            :item="{
                title: 'MyLibrary',
                to: '/myLibraries',
            }"
        />
        <VerticalNavSectionTitle :item="{ heading: 'subscribemanage' }" />
        <VerticalNavLink
            :item="{
                title: 'Subscriber',
                to: '/subscribers',
            }"
        />
        <VerticalNavSectionTitle :item="{ heading: 'authormanage' }" />
        <VerticalNavLink
            :item="{
                title: 'Author',
                to: '/authors',
            }"
        />
        <VerticalNavSectionTitle :item="{ heading: 'Outside' }" />
    </ul>
</template>
