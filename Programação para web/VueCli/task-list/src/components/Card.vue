<template>
  <div @click="cardChanged" class="card" :style="{'background-color': isDone ? 'green' : 'red'}">
    <strike v-if="isDone">{{text}}</strike>
    <span v-else>{{text}}</span>
    <button @click="deleteCard" class="delete-button">x</button>
  </div>
</template>
<script>
export default {
  name: "Card",
  props: {
    id: Number,
    text: String,
    active: Boolean
  },
  data() {
    return {
      isDone: false      
    };
  },
  methods: {
    cardChanged() {
      this.isDone = !this.isDone;
      this.$store.commit('updateCard', this);
    },
    deleteCard(){
        this.$store.commit('deleteCard', this.id);
    }
  }
};
</script>
<style>
.card {
  height: 100px;
  width: 15%;
  color: white;
  border-radius: 5%;
  text-align: center;
  margin: 1%;
  float: left;
  text-overflow: ellipsis;
  overflow: hidden;
}

.delete-button {  
  right: 10px;
  top: 5px;
}
</style>