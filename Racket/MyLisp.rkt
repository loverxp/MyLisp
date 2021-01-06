#lang racket

(provide interp)

(define (interp s)
  (define (interp s env)
    (print "env: ")
    (println env)
    (print "exp: ")
    (println s)

    (define (ext-env k v)
      (cons (cons k v) env))

    (define (lookup k)
      (let ([p (assq k env)])
        (cond
          [(not p) #f]
          [else (cdr p)])))
  
    (match s
      [(? number? s) s]
      [(? symbol? s) (lookup s)]
    
      [`(let ([,x ,e1]) ,e2)
       (println "-----------let:" )
       (interp e2 (ext-env x e1))]
      
      [`(,e1 ,e2)                      ;函数调用
       (println "-----------call")
         (match e1
           [`(lambda (,x) ,e)
            (interp e (ext-env x e2))]
           [(? symbol? e1) (interp `(,(lookup e1) ,e2) env)])]
      
      [`(,op ,a ,b)
       (let ([x (interp a env)]
             [y (interp b env)])
         (match op
           ['+ (+ x y)]
           ['- (- x y)]
           ['* (* x y)]
           ['/ (/ x y)]
           [else (error "unsupported oprator:" op)]
           ))]
      [else (error "unsupported expression:" s)]))
  
  (interp s '()))

