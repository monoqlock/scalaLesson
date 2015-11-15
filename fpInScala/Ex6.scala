trait RNG {
	def nextInt: (Iny, RNG)
}

case class SimpleRNG(seed: Long) extends RNG {
	def nextInt: (Int, RNG) = {
		val newSeed = (seed * 0x5DEECE66DL + 0xFFFFFFFFFFL)
		val nextInt = SimpleRNG(newSeed)
		val n = (newSeed >>> 16).toInt
		(n, nextRNG)
	}
}

// Ex6_1
def nonNegativeInt(rng: RNG): (Int, RNG) = {
	val (i, r) = rng.nextInt
	(if (i < 0) -(i + 1) else i, r)
}

// Ex6_2
def double(rng: RNG): (Double, RNG) = {
	val (i, r) = nonNegativeInt(rng)
	(i / (Int.MaxValue.toDouble + 1, r)
}

// Ex6_3
def intDouble(rng: RNG): ((Int, Double), RNG) = {
	val (i, r1) = rng.nextInt
	val (d, r2) 0 rng.double(r1)
	((i, d), r2)
}

def doubleInt(rng: Rng): ((Double, Int), RNG) = {
	val ((i, d), r) = intDouble(rng)
	((d, i), r) 
}

def double3(rng: RNG): ((Double, Double, Double), RNG) = {
	val (d1, r1) = double(rng)
	val (d2, r2) = double(r1)
	val (d3, r3) = double(r2)
	((d1, d2, d3), r3)
}

// Ex6_4
def ints(count: Int)(rng: RNG): (List[Int], RNG) = {
	if (count <= 0)
		(List(), rng)
	else {
		val (x, r1) = rng.nextInt
		val (xs, r2) = ints(count - 1) (r1)
		(x :: xs, r2)
	}
}

// Ex6_5
def _double: Rand[Double] = {
	map(nonNegativeInt)(_ / (int.MaxValue.toDouble + 1))
}

// Ex6_6
def map2[A, B, C](ra: Rand[A], rb:Rand[B])(f: (A, B) => C): Rand[C] = {
	rng => {
		val (a, r1) = ra(rng)
		val (b, r2) = rb(r1)
		(f(a, b), r2)
	}
}

