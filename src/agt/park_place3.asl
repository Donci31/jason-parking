+auction(N)[source(S)] : not occupied(park_place3)
   <- .send(S, tell, place_bid(N, 3)).

+auction(N)[source(S)] : occupied(park_place3)
   <- .send(S, tell, place_bid(N, 0)).
