package cs320

import scala.reflect.ClassTag

case class PLError(msg: String) extends Exception(msg)

trait Assignment {

  def error(): Nothing = error("")

  def error(msg: String): Nothing = throw PLError(msg)

  def cast[T](v: Any, msg: => String)(implicit tag: ClassTag[T]): T = v match {
    case v: T => v
    case v => error(msg)
  }
}
