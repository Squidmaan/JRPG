package main

class Character {

  var attackPower : Int = 7
  var defense : Int = 3
  var magicAttack : Int = 4
  var magicDefense : Int = 2
  var maxHealth : Int = 100
  var currentHealth : Int = maxHealth
  var maxMagic : Int = 100
  var currentMagic : Int = maxMagic
  var alive : Boolean = true

  def takeDamage(oof: Int): Unit = {

    currentHealth = currentHealth + oof
    if (currentHealth <= 0) {
      alive = false
    }
  }
  def physicialAttack(attacker: Character): Unit =  {
    var damage: Int = defense - attacker.attackPower
    takeDamage(damage)
  }
  def magicalAttack(attacker: Character): Unit = {
    if(attacker.currentMagic >= 5){
      var damage: Int = magicDefense - attacker.magicAttack
      takeDamage(damage)
      attacker.currentMagic -= 5
  }
  }



}
