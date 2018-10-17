package bowling

import org.scalatest.{FunSpec, Matchers}

class BowlingSpec extends FunSpec with Matchers {

  val game1 = new Bowling();
  val game2 = new Bowling();
  val game3 = new Bowling()


    describe("First Game : 2 spares and 5 pins down") {

      game3.shoot(0)
      game3.shoot(0)


      game1.shoot(4)
      game1.shoot(6)

      game1.shoot(4)
      game1.shoot(6)

      game1.shoot(3)
      game1.shoot(2)
        it("should give score 32 -> "+game1.getScore) {
            assert(game1.getScore == 32)
        }
      it("should give score 0 ->"+game3.getScore){
        assert(game3.getScore == 0)
      }
    }

    describe("Second game : 10 stricks") {

      game2.shoot(10)
      game2.shoot(10)
      game2.shoot(10)
      game2.shoot(10)
      game2.shoot(10)
      game2.shoot(10)
      game2.shoot(10)
      game2.shoot(10)
      game2.shoot(10)
      game2.shoot(10)
      it("should give score") {
        assert(game2.getScore == 300)
      }
    }



}
