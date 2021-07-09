package nl.woetroe.nn.function.activation;

import java.io.Serializable;
import java.util.function.Function;

/*
  Copyright (C) 2020-2021, Wouter Kistemaker.
  This program is free software: you can redistribute it and/or modify
  it under the terms of the GNU Affero General Public License as published
  by the Free Software Foundation, either version 3 of the License, or
  (at your option) any later version.
  This program is distributed in the hope that it will be useful,
  but WITHOUT ANY WARRANTY; without even the implied warranty of
  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
  GNU Affero General Public License for more details.
  You should have received a copy of the GNU Affero General Public License
  along with this program.  If not, see <https://www.gnu.org/licenses/>.
*/

/**
 * Represents an activation function that as applied to the weighted sum
 * in the process of feedforwarding.
 *
 * @implNote It is important to notice that the choice of the activation function has
 * a huge impact on the outcome of the network. One has to understand that a network,
 * that uses the Sigmoid activation function, can never be trained to give an output
 * of 6, or -73, because after application of the AF, the outcome will always lay between 0 and 1.
 *
 *
 */
public interface ActivationFunction extends Function<Double, Double>, Serializable {

    double applyDerivative(double d);
}

