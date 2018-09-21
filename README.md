# KinematicsCalculator
Calculator for solving simple physics kinematics problems

Prints a list of all the known and solved variables, followed by a short statement of the situation.

Variables:

	a = acceleration in meters/second^2
	v0 = initial velocity in meters/second
	v = velocity in meters/second
	x0 = initial displacement in meters
	x = displacement in meters
	t = time in seconds

Use as many known variables as needed in any order.
Put in variables as arguments like this:

	java kinematicsUI t:2.3 a:-9.8 v0:16.2
output:

	a:	-9.8
	v0:	16.2
	v:	-6.34
	x0:	null
	x:	null
	t:	2.3
	
	The particle is moving at 16.2 meters per second, accelerating at a rate of -9.8 meters per second squared.
	After 2.3 seconds, the particle is moving at -6.34 meters per second.
