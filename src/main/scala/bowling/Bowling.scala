package bowling
import scala.collection.immutable.Set
import scala.util.Random

class Bowling {

  var frames = List[Frame]()

  /**
    * 
    * @param roll1
    * @param roll2
    */
  case class Frame(roll1: Int, var roll2: Int = 0) {
    //definition of strike (first roll ten pins)
    def strike = roll1 == 10
    //if frame has to rolls or 1 roll and a strike
    var frameFinished: Boolean = false
    if (strike) frameFinished = true
    def sum = roll1 + roll2
  }

  /**
    * 
    * @param touchedPins
    */
  def shoot(touchedPins: Int) {
    //If the frames list is not empty and if the last frame is not finished
    if (frames.size > 0 && !frames.last.frameFinished) {
      //it's the second shoot of a frame
      frames.last.frameFinished = true
      frames.last.roll2 = touchedPins
    } else {
      //First shoot so adding a new frame
      frames = frames :+ Frame(touchedPins)
    }
  }

  /**
    * 
    * @return
    */
  def getScore: Int = {
    processScore(0,frames)
  }

  /**
    * 
    * @param total
    * @param framesLeft
    * @return
    */
  def processScore(total: Int, Lframes: List[Frame]): Int = {
    var tempScore = Lframes.head.sum
    if (Lframes.tail != Nil && Lframes.head.sum == 10) {
      tempScore += Lframes(1).roll1 //adding the score of the current frame
      if (Lframes.head.strike) { //if spare or strike then we get score for next
        if (!Lframes(1).strike) tempScore += Lframes(1).roll2
        else {
          if(Lframes.length>=2){
            tempScore += Lframes(2).roll1
          }

        } //Strike so only add score of roll 1 from next
      }
    }
    if (!Lframes.tail.isEmpty && (frames.size - Lframes.tail.size) < 10) processScore(total + tempScore,Lframes.tail)
    else total + tempScore
  }




}



