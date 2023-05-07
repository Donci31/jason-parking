+auction(N)[source(S)] : not occupied(park_place2)
   <- .send(S, tell, place_bid(N, 2)).

+auction(N)[source(S)] : occupied(park_place2)
   <- .send(S, tell, place_bid(N, 0)).
