<template>
  <div id="app">
    <label for="file" style="color: white;">Tasks completed</label>
    <progress id="tasks-Completed" max="100" :value="tasksCompleted">{{tasksCompleted}}%</progress>
    <div>
      <input
        v-model="taskDescription"
        placeholder="New task"
        type="text"
        name="new-card"
        id="new-card"
      />
      <button @click="addCard(cards.length)">Add</button>
    </div>
    <div class="cards" v-for="(card, index) in cards" :key="index">
      <Card :id="index" :text="card.text" :active="card.active" :done="card.done" />
    </div>
  </div>
</template>

<script>
import Card from "./components/Card.vue";

export default {
  name: "App",
  components: {
    Card
  },
  computed: {
    cards() {
      return this.$store.state.cards;
    },
    tasksCompleted() {
      return this.$store.state.tasksCompletePercent;
    }
  },
  data: function() {
    return {
      taskDescription: ""      
    };
  },
  methods: {
    addCard(cardId) {
      this.$store.commit("addCard", {
        id: cardId,
        text: this.taskDescription,
        active: true,
        done: false
      });
      this.taskDescription = "";
    }
  }
};
</script>

<style>
.cards {
  margin: 0 auto;
}
body {
  background-color: black;
}
</style>
