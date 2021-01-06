#lang racket

(require "MyLisp.rkt")


(define s1 '(1 2 + 1 2 1))
(define s2 '(* 4 5))
(define s3 '(* (+ 1 2) (- 3 2)))

(define s4 '(*(+ 1 2 2)(- 3 2)))

(define s5 '(* (+ 3 2) (- 4 7)))
(define s100 '(* 5254 27))

(define sl1 '(lambda (x) x))

(define sl21 '((lambda (x) x) 10) )
(define sl22 '((λ (x) x) 10) )
(define sl3 '((lambda (x) (* x x)) 10) )
(define sl4 '((lambda (x) (* x (* x x))) 10) )
(define sl5 '(let ([x 10])(+ x (* x x))) )
(define sl6 '(let ([x 4])(let ([y 5])(+ y (* x x)))) )

(define sl7 '((define add (+ 10 10))add))

;(define sl8 '(let ([x 4])(let ([y 5])(+ y (* x x)))) )

(define sl8  '(let ([x 2])
                (let ([f (lambda (y) (* x y))])
                  (f 3))))

(define sl9 '(let ([x 2])
               (let ([f (lambda (y) (* x y))])
                 (let ([x 4])
                   (f 3)))))

;(define (test x) (+ x (* x x)))

;((lambda (x) x) 10)


;(calculate s3)

;(interp0 sl4)

;(interp sl1)
;(interp sl21)
;(interp sl22)
;(interp sl3 env0)
;(interp sl4)
;(interp sl5)
;(interp sl6)
;(interp sl8)
(interp sl9)

;(interp1 sl6)
;(interp1 sl7)

;(calculate2 s2)
;(calculate s5)

;(eval '((#lang racket) (* 4 4)))
;(eval '(* 4 4))
;(eval sl2)
;(eval sl3)

;(calculate s5)
;(calculate s5)

;(interp 'x)
;(interp '(a b))
;(interp '(let ([x e1]) e2))
;(interp '(test 10))

;(test 10)

;(define rest (cons (cons 3 4) (cons (cons 5 6) null)))
;rest
;(cons (cons 1 2) rest)
; (cons (cons 1 2) (cons (cons 3 4) (cons (cons 5 6) null)))

(define tt
  (let ([x 2])
    (let ([f (lambda (y) (* x y))])
      (let ([x 4])
        (f 3)))))

; (+ a a)

(define a 33)
(let ([x a]) (* x x))

