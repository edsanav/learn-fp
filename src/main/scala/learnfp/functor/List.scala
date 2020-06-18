package learnfp.functor

object ListInstance {
  // My solution without relying on List functor, not optimized for tail rec though
  //  implicit val listInstance:Functor[List] = new Functor[List] {
  //    override def fmap[A, B](a: List[A])(fx: A => B): List[B] = a match {
  //      case Nil => Nil
  //      case x::xs => fx(x)::fmap(xs)(fx)
  //    }
  //  }
  implicit val listInstance:Functor[List] = new Functor[List] {
    override def fmap[A, B](a: List[A])(fx: A => B): List[B] = a map fx
  }
}
