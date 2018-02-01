import React from 'react';
import {StyleSheet, Text, Alert, Button, View, NativeModules} from 'react-native';


export default class ETH extends React.Component {
    render() {
        return (
            <View style={styles.container}>
                <Button title="button" onPress={() => {
                    NativeModules.CreateAccountNativeModule.createAccount("Hello", (str) => {
                        Alert.alert(str);
                    })
                }}/>
            </View>
        );
    }
}

const styles = StyleSheet.create({
    container: {
        flex: 1,
        backgroundColor: '#fff',
        alignItems: 'center',
        justifyContent: 'center',
    },
});