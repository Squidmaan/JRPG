package main
import main.Character
class Party {
  var member5 : Character = new Character
  var member6 : Character = new Character
  var member7 : Character = new Character
  var member8 : Character = new Character

  var mainParty = List(member5,member6,member7,member8)

    def setParty(member1: Character,member2: Character, member3: Character, member4 : Character): Unit ={
      mainParty = List(member1,member2,member3,member4)
    }

    def defeatParty(evilParty: Party): Unit = {
      for(member <- mainParty){
        if(member.currentHealth > 0) {
          for(enemy <- evilParty.mainParty){
            member.winBattle(enemy)
          }
        }

      }

    }

}
