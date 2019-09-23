package tests

import org.scalatest._
import main.Character

class TestDamage extends FunSuite {

  test("Testing the player taking damage") {
    var myCharacter : Character = new Character
    var largeOof = -105
    var mediumOof = -50
    var smollOof = -10


    myCharacter.takeDamage(smollOof)
    assert(myCharacter.currentHealth == 90)
    myCharacter.takeDamage(mediumOof)
    assert(myCharacter.currentHealth == 40)
    myCharacter.takeDamage(largeOof)
    assert(myCharacter.currentHealth == -65)
  }
  test(" Testing physical and magic attacks on another player") {
    var attacker : Character = new Character
    var defender : Character = new Character

    attacker.physicalAttack(defender)
    assert(defender.currentHealth == 96)
    attacker.magicalAttack(defender)
    assert(defender.currentHealth == 94)
    assert(attacker.currentMagic == 95)
    attacker.currentMagic = 0
    attacker.magicalAttack(defender)
    assert(defender.currentHealth == 94)
  }
  test("Gaining xp and leveling up and winning battles") {
    var attacker : Character = new Character
    var defender : Character = new Character

    attacker.winBattle(defender)
    assert(attacker.xp > 0)

    attacker.gainXP(60)
    assert(attacker.level == 2)

    attacker.gainXP(300)
    assert(attacker.level == 5)

    attacker.levelUp()
    assert(attacker.level == 6)





  }


}
