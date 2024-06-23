package com.soccer;

import java.util.Hashtable;

import com.soccer.entity.Coach;
import com.soccer.entity.Doctor;
import com.soccer.entity.Player;
import com.soccer.entity.Team;

public class Controller {
    public Hashtable <String, Team> equipos = new Hashtable<>();
    public Hashtable <String, Player> jugadores = new Hashtable<>();
    public Hashtable <String, Coach> entrenadores = new Hashtable<>();
    public Hashtable <String, Doctor> masajistas = new Hashtable<>();
}
