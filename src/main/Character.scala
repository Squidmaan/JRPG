package main

class Character {

  var level : Int = 1
  var xp : Int = 0
  var xpNeeded : Int = 50

  var attackPower : Int = 7
  var magicAttack : Int = 4

  var defense : Int = 3
  var magicDefense : Int = 2

  var maxHealth : Int = 100
  var currentHealth : Int = maxHealth

  var maxMagic : Int = 100
  var currentMagic : Int = maxMagic

  var alive : Boolean = true

  //Tracks how many times a character has attacked physically and magically
  var phyAttacks : Int = 0
  var magAttacks : Int = 0
  //Tracks how many times a character has defended physically and magically
  var phyDefends : Int = 0
  var magDefends : Int = 0

  def takeDamage(oof: Int): Unit = {

    currentHealth = currentHealth + oof
    if (currentHealth <= 0) {
      alive = false
    }
  }
  def physicalAttack(defender: Character): Unit =  {
    var damage: Int = defender.defense - attackPower
    defender.takeDamage(damage)

    phyAttacks += 1
    defender.phyDefends += 1
  }
  def magicalAttack(defender: Character): Unit = {
    if (currentMagic >= 5) {
      var damage: Int = defender.magicDefense - magicAttack
      defender.takeDamage(damage)
      currentMagic -= 5

      magAttacks += 1
      defender.magDefends += 1
    }
  }
    def winBattle(loser : Character): Unit = {
      if(level == loser.level){
        gainXP(math.ceil(loser.level * 2.0).toInt)
      }
      else if(level > loser.level){
        gainXP(math.ceil(loser.level * 1.5).toInt)
      }
      else{
        gainXP(math.ceil(loser.level * 3.0).toInt)
      }

    }

    def gainXP(xpGain: Int) : Unit = {
      xp +=  xpGain
      while(xp >= xpNeeded) {
        levelUp()
        if(xp > xpNeeded){
          xp = xp - xpNeeded
        }else {
          xp = 0
        }
        xpNeeded = (xpNeeded * 1.2).toInt
      }

    }
    def levelUp(): Unit = {
      level += 1
      attackPower = math.ceil(attackPower + level + phyAttacks / 5).toInt
      magAttacks = math.ceil(attackPower + level + magAttacks / 5).toInt

      defense = math.ceil(defense + level + defense + phyDefends / 5).toInt
      magicDefense = math.ceil(magicDefense + level + magicDefense + magDefends / 5).toInt

      maxHealth *= math.ceil(1.2).toInt
      currentHealth = maxHealth

      maxMagic *= math.ceil(1.2).toInt
      currentMagic = maxMagic

    }
}
