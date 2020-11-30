package nl.woetroe.nn.neuron;

import nl.woetroe.nn.util.NetworkUtils;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
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
public final class Neuron implements Serializable {

    private static final long serialVersionUID = 4240182149384801865L;
    private double value;
    private final Set<NeuronConnection> connections;
    private boolean isBiasNeuron = false;

    private double delta;

    public Neuron(double value) {
        this.value = value;
        this.connections = new HashSet<>();
    }

    public Neuron() {
        this(NetworkUtils.nextDouble());
    }

    public Neuron(boolean isBiasNeuron) {
        this(isBiasNeuron ? 1 : NetworkUtils.nextDouble());
        this.isBiasNeuron = isBiasNeuron;
    }

    public void connect(Neuron t) {
        this.connections.add(new NeuronConnection(this, t));
    }

    public Set<NeuronConnection> getConnections() {
        return connections;
    }

    public NeuronConnection getConnectionWith(Neuron target) {
        return connections.stream().filter(c -> c.getTo().equals(target) || c.getFrom().equals(target)).findFirst().orElse(null);
    }

    public double getValue() {
        return value;
    }

    public boolean isBiasNeuron() {
        return isBiasNeuron;
    }

    public void adjustValue(double x) {
        value += x;
    }

    public void setValue(double value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Neuron{" +
                "value=" + value +
                ", connections=" + connections +
                ", isBiasNeuron=" + isBiasNeuron +
                ", delta=" + delta +
                '}';
    }

    public double getDelta() {
        return delta;
    }

    public void setDelta(double delta) {
        this.delta = delta;
    }
}

