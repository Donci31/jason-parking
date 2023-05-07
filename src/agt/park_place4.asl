+auction(N)[source(S)] : not occupied(park_place4)
   <- .send(S, tell, place_bid(N, 4)).

+auction(N)[source(S)] : occupied(park_place4)
   <- .send(S, tell, place_bid(N, 0)).
