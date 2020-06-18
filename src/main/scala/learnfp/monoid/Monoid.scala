package learnfp.monoid

trait Monoid[A] {
  def mzero:A
  def mappend(lhs:A, rhs:A):A
}

object Monoid {

  def apply[A](implicit monoid: Monoid[A]):Monoid[A] = monoid

  def mzero[A](implicit monoid:Monoid[A]):A = monoid.mzero
}

class MonoidOps[A:Monoid](lhs:A) {
  // EDU: Put in the class because it's to be used as  A op B
  def |+|(rhs:A):A = Monoid[A].mappend(lhs, rhs)
}

object MonoidOps {
  implicit def toMonoidOps[A](x:A)(implicit monoid:Monoid[A]):MonoidOps[A] = new MonoidOps[A](x)
}
