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

    defender.physicialAttack(attacker)
    assert(defender.currentHealth == 96)
    println(defender.magicDefense - attacker.magicAttack)
    defender.magicalAttack(attacker)
    assert(defender.currentHealth == 94)
    assert(attacker.currentMagic == 95)
  }


}
