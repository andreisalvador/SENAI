import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    cards: [],
    tasksCompletePercent: 0
  },
  mutations: {
    deleteCard(state, cardId) {
      console.log("Deleted Card")

      state.cards.splice(cardId, 1)
    },
    updateCard(state, card) {      
      if (card.id === undefined) return

      console.log("Updated Card")      

      let cardProps = ["id", "text", "active"];

      cardProps.forEach(field => {
        state.cards[card.id][field] = card[field];
      });
      state.cards[card.id].done = card.isDone;

      let cardsQuantity = state.cards.length;
      let doneCards = state.cards.filter(x => x.done).length;

      state.tasksCompletePercent = (doneCards * 100) / cardsQuantity;
    },
    addCard(state, card) {
      console.log("Added Card")
      state.cards.push(card)
    }
  },
  actions: {
  },
  modules: {
  }
})
