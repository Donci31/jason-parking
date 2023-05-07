+auction(N)[source(S)] : not occupied(park_place1)
   <- .send(S, tell, place_bid(N, 1)).

+auction(N)[source(S)] : occupied(park_place1)
   <- .send(S, tell, place_bid(N, 0)).
