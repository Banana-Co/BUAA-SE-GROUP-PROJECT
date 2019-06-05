<template>
    <div>
        <h3>所有注册用户</h3>
        <ul>
            <li v-for="item in list">
                {{item.user_name}}
            </li>
        </ul>
    </div>
</template>

<style>
    ul{padding: 0;}
    ul li{list-style: none;}
</style>

<script>
    export default{
        data(){
            return{
                list: ''
            }
        },
        mounted(){
            this.$axios.get('/user').then((res)=>{
                this.list = res.data
                console.log(res)
            })
        }
    }
</script>