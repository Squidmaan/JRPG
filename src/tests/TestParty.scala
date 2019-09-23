package tests

import main.Character
import main.Party
import org.scalatest._
class TestParty extends FunSuite  {
  test("Testing defeat party"){
    var member1 : Character = new Character
    var member2 : Character = new Character
    var member3 : Character = new Character
    var member4 : Character = new Character

    var member5 : Character = new Character
    var member6 : Character = new Character
    var member7 : Character = new Character
    var member8 : Character = new Character

    var myParty : Party = new Party
    var evilParty: Party = new Party
    myParty.setParty(member1,member2,member3,member4)
    evilParty.setParty(member5,member6,member7,member8)

    myParty.defeatParty(evilParty)
    assert(member1.xp == 8)
    assert(member2.xp == 8)
    assert(member3.xp == 8)
    assert(member4.xp == 8)


    for(evilDoer <- evilParty.mainParty) {
      evilDoer.levelUp
    }
    myParty.defeatParty(evilParty)
    assert(member1.xp == 32)
    assert(member2.xp == 32)
    assert(member3.xp == 32)
    assert(member4.xp == 32)

    evilParty.defeatParty(myParty)
    assert(member5.xp == 8)
    assert(member6.xp == 8)
    assert(member7.xp == 8)
    assert(member8.xp == 8)




  }


}
