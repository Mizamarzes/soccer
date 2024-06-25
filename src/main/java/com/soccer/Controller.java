package com.soccer;

import java.util.Hashtable;

import com.soccer.entity.Coach;
import com.soccer.entity.Doctor;
import com.soccer.entity.Player;
import com.soccer.entity.Team;

public class Controller {
    public Hashtable <Integer, Team> equipos = new Hashtable<>();
    public Hashtable <Integer, Player> jugadores = new Hashtable<>();
    public Hashtable <Integer, Coach> entrenadores = new Hashtable<>();
    public Hashtable <Integer, Doctor> doctores = new Hashtable<>();
}
