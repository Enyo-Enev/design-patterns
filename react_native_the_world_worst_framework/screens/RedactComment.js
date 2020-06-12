import React, { useState } from 'react';
import { StyleSheet, Text, View, TextInput} from 'react-native';

export default function RedactComment({ navigation }) {

	return (
		<View style={styles.container}>
			<Text style={styles.textEntry}>Redact email:</Text>
			<TextInput
				placeholder='e.g. myemail@email.com'
				//NOTE(enev): This for some reason is miserably slow!
				//why they dont have a setParam! Poor design maybe!
				//
				// I dont want a fucking copy I dont how to tell it 
				// hey get me the pointer to the value of the item from the list in the home page??
				// CRAZY LANGUAGE CRAZY FRAMEWORK!
				// PROGRAM IN C DONT WASTE YOUR TIME 
				// LEAVE THIS ALONE
				// HOLY SHIT HOW BAD AND SLOW IT IS!
				//
				// hah they call it lifting state up or sth., but how to do it when i am coming from a stack
				// complete crap!
				onChangeText={(defaultVal) => {navigation.setParams(
					{postId: navigation.getParam('postId'), id: navigation.getParam('id'), name: navigation.getParam('name'), email: defaultVal, body: navigation.getParam('body')}
				)}}
				style={styles.input}/>

			<Text style={styles.textEntry}>Redact body:</Text>
			<TextInput 
				placeholder='e.g. Hello!'
				onChangeText={(defaultVal) => {navigation.setParams(
					{postId: navigation.getParam('postId'), id: navigation.getParam('id'), name: navigation.getParam('name'), email: navigation.getParam('email'), body: defaultVal}
				)}}
				style={styles.input}/>

		<View style={styles.result}>
			<Text style={styles.textEntry}>Comment email:</Text>
			<Text>{navigation.getParam('email')}</Text>
			<Text style={styles.textEntry}>Comment body:</Text>
			<Text>{navigation.getParam('body')}</Text>
		</View>
		</View>
	)
}

const styles = StyleSheet.create({
	container: {
		flex: 1,
		backgroundColor: '#fff',
		alignItems: 'center',
		justifyContent: 'center'
	},
	result: {
		backgroundColor: 'yellow',
		alignItems: 'center',
	},
	textEntry: {
		fontWeight: 'bold',
		margin: 10
	},
	input: {
		borderWidth: 1,
		borderColor: '#777',
		padding: 8,
		margin: 10,
		width: 100
	}
})
