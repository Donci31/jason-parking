+auction(ID, N)[source(S)] : not occupied(park_place1) & auction(ID, 1)
   <- .send(S, tell, place_bid(N, 2)).

+auction(ID, N)[source(S)] : not occupied(park_place1) & auction(ID, 2)
   <- .send(S, tell, place_bid(N, 2)).

+auction(ID, N)[source(S)] : not occupied(park_place1) & not auction(ID, 1) & not auction(ID, 2)
   <- .send(S, tell, place_bid(N, 1)).

+auction(ID, N)[source(S)] : occupied(park_place1)
   <- .send(S, tell, place_bid(N, 0)).
